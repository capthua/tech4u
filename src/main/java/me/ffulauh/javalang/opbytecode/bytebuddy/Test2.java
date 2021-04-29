package me.ffulauh.javalang.opbytecode.bytebuddy;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import me.ffulauh.javalang.opbytecode.bytebuddy.model.HanShao;
import me.ffulauh.javalang.opbytecode.bytebuddy.model.HanHua;
import me.ffulauh.javalang.opbytecode.bytebuddy.model.THanShaoH;
import me.ffulauh.javalang.opbytecode.bytebuddy.model.THanShaoHua;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationDescription.Builder;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.matcher.ElementMatcher;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Ref;
import java.util.Arrays;
import java.util.List;


public class Test2 {

    private static Converter<String,String> lc2LuConverter=
            CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
    private static Converter<String,String> uc2LuConverter=
            CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);


    public static void main(String[] args) {

        Class<HanShao> han1= HanShao.class;
        Class<HanHua> han2= HanHua.class;
        Class<THanShaoH> han3=THanShaoH.class;
        Class<THanShaoHua> han4=THanShaoHua.class;
        ByteBuddy byteBuddy=new ByteBuddy();
        ByteBuddyAgent.install();
        List<Class> classes= Lists.newArrayList(han1,han2,han3,han4);

        addAnnotation(classes,byteBuddy);
    }

    private static void addAnnotation(List<Class> classes,ByteBuddy byteBuddy){
        for(Class clazz:classes){
            boolean redifine=false;
            DynamicType.Builder builder=byteBuddy.redefine(clazz);
            if(!containsAnnotation(clazz,Table.class)){
                Builder tableAnnotationBuilder= Builder.ofType(Table.class);
                String tableName=uc2LuConverter.convert(clazz.getSimpleName());
                builder = builder.annotateType(tableAnnotationBuilder.define("name",tableName).build());
                redifine=true;
            }
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                Class annotationType;
                if(field.getName().equals("id")){
                    annotationType= Id.class;
                } else {
                    annotationType=Column.class;
                }
                if(!containsAnnotation(field,annotationType)){
                    Builder columnAnnotationBuilder= Builder.ofType(annotationType);
                    if(!field.getName().equals("id")){
                        columnAnnotationBuilder= columnAnnotationBuilder.define("name", lc2LuConverter.convert(field.getName()));
                    }
                    builder = builder.field((ElementMatcher<FieldDescription>) target -> target.getName().equals(field.getName()))
                                    .annotateField(columnAnnotationBuilder.build());
                    redifine=true;
                }
            }
            if(redifine){
                builder.make().load(ByteBuddy.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
            }
            printAnnotations(clazz);
        }

    }

    private static boolean containsAnnotation(Field field,Class annotationType){
        return containsAnnotation(field.getAnnotations(),annotationType);
    }
    private static boolean containsAnnotation(Class clazz,Class annotationType){
        return containsAnnotation(clazz.getAnnotations(),annotationType);
    }
    private static boolean containsAnnotation(Annotation[] srcAnnotations,Class annotationType){
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
        Annotation[] classAnnotations=clazz.getAnnotations();
        List<Field> fields=Arrays.asList(clazz.getDeclaredFields());
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

}
