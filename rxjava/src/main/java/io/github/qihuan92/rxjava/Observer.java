package io.github.qihuan92.rxjava;

/**
 * Observer
 *
 * @author qi
 * @since 2021/11/23
 */
public interface Observer<T> {
    void onSubscribe();

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
