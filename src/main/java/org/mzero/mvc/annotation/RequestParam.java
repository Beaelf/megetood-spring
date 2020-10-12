package org.mzero.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求方法参数名称
 *
 * @author chengdong.lei@hand-china.com 2020/08/16 19:36
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
    /**
     * 方法参数名称
     * @return
     */
    String value() default "";

    /**
     * 参数是否必须
     * @return
     */
    boolean required() default true;
}
