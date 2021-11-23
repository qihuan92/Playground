package io.github.qihuan92.rxjava;

/**
 * Function
 *
 * @author qi
 * @since 2021/11/23
 */
public interface Function<T, R> {
    R apply(T t);
}
