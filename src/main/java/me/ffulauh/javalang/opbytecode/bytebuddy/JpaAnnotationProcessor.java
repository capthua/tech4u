package me.ffulauh.javalang.opbytecode.bytebuddy;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
//import com.iline.saas.entity.mapper.THtCMapper;
//import com.iline.saas.entity.model.THtC;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.matcher.ElementMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Component
//public class JpaAnnotationProcessor implements ApplicationRunner {
public class JpaAnnotationProcessor{

    //@Autowired
    //THtCMapper tHtCMapper;

    private static final Logger logger= LoggerFactory.getLogger(JpaAnnotationProcessor.class);

    private static Converter<String,String> lc2LuConverter=
            CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
    private static Converter<String,String> uc2LuConverter=
            CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);

    private static void addAnnotation(List<Class> classes, ByteBuddy byteBuddy){
        for(Class clazz:classes){
            boolean redefine=false;
            DynamicType.Builder builder=byteBuddy.redefine(clazz);
            if(!containsAnnotation(clazz, Table.class)){
                AnnotationDescription.Builder tableAnnotationBuilder= AnnotationDescription.Builder.ofType(Table.class);
                String tableName=uc2LuConverter.convert(clazz.getSimpleName());
                builder = builder.annotateType(tableAnnotationBuilder.define("name",tableName).build());
                logger.info("给类:{}添加table注解",clazz.getName());
                redefine=true;
            }
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                Class annotationType;
                if(field.getName().equals("id")){
                    annotationType= Id.class;
                } else {
                    annotationType= Column.class;
                }
                if(!containsAnnotation(field,annotationType)){
                    AnnotationDescription.Builder columnAnnotationBuilder= AnnotationDescription.Builder.ofType(annotationType);
                    if(!field.getName().equals("id")){
                        columnAnnotationBuilder= columnAnnotationBuilder.define("name", lc2LuConverter.convert(field.getName()));
                    }
                    builder = builder.field((ElementMatcher<FieldDescription>) target -> target.getName().equals(field.getName()))
                            .annotateField(columnAnnotationBuilder.build());
                    redefine=true;
                    logger.info("给类{}的{}添加注解{}",clazz.getName(),field.getName(),annotationType.getName());
                }
            }
            if(redefine){
                builder.make().load(Thread.currentThread().getContextClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
            }
        }

    }

    private static boolean containsAnnotation(Field field,Class annotationType){
        return containsAnnotation(field.getAnnotations(),annotationType);
    }
    private static boolean containsAnnotation(Class clazz,Class annotationType){
        return containsAnnotation(clazz.getAnnotations(),annotationType);
    }
    private static boolean containsAnnotation(Annotation[] srcAnnotations, Class annotationType){
        boolean result=false;
        for(Annotation srcAnnotation:srcAnnotations){
            if(annotationType.equals(srcAnnotation.annotationType())){
                result=true;
                break;
            }
        }
        return result;
    }

    private static void printAnnotations(Class clazz){
        List<Field> fields= Arrays.asList(clazz.getDeclaredFields());
        fields.forEach(field -> {
            System.out.println(field.getName()+" annotations:");
            Annotation[] fieldAnnotations = field.getAnnotations();
            for (Annotation annotation : fieldAnnotations) {
                System.out.println(annotation);
            }
        });
        System.out.println("class annotations:");
        System.out.println(Arrays.asList(clazz.getAnnotations()));
    }

    //@Override
    //public void run(ApplicationArguments args) {
    //    //ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
    //    //Field f= null;
    //    //try {
    //    //    f = ClassLoader.class.getDeclaredField("classes");
    //    //    f.setAccessible(true);
    //    //    Vector<Class> classes = (Vector<Class>)f.get(classLoader);
    //    //    List<Class> models = classes.stream().filter(clazz->clazz.getName().contains("entity" +
    //    //            ".model")).collect(Collectors.toList());
    //    //    ByteBuddy byteBuddy=new ByteBuddy();
    //    //    ByteBuddyAgent.install();
    //    //    addAnnotation(models,byteBuddy);
    //    //} catch (Exception e) {
    //    //    e.printStackTrace();
    //    //}
    //    List<THtC> htCS = tHtCMapper.selectAll();
    //    logger.info("hehe");
    //}
}
