package me.ffulauh.javalang.opbytecode.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * 运行时创建类
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        DynamicType.Unloaded unloadedType=
                new ByteBuddy().subclass(Object.class).method(ElementMatchers.isToString())
                        .intercept(FixedValue.value("Hello world bytebuddy")).make();
        Class<?> dynamicType=unloadedType.load(Test.class.getClassLoader()).getLoaded();
        System.out.println(dynamicType.newInstance().toString());
    }

}
