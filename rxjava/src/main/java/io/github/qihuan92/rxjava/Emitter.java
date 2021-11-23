package io.github.qihuan92.rxjava;

/**
 * Emitter
 *
 * @author qi
 * @since 2021/11/23
 */
public interface Emitter<T> {
    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
