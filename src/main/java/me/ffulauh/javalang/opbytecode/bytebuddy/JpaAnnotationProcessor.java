package me.ffulauh.javalang.opbytecode.bytebuddy;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.matcher.ElementMatcher;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class JpaAnnotationProcessor {

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
                redefine=true;
            }
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                if(!containsAnnotation(field, Column.class)){
                    AnnotationDescription.Builder columnAnnotationBuilder= AnnotationDescription.Builder.ofType(Column.class);
                    columnAnnotationBuilder= columnAnnotationBuilder.define("name", lc2LuConverter.convert(field.getName()));
                    builder = builder.field((ElementMatcher<FieldDescription>) target -> target.getName().equals(field.getName()))
                            .annotateField(columnAnnotationBuilder.build());
                    redefine=true;
                }
            }

            if(redefine){
                builder.make().load(Test2.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
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

}
