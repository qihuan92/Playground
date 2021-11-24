package io.github.qihuan92.rxjava;

/**
 * ObservableSource
 *
 * @author qi
 * @since 2021/11/23
 */
public interface ObservableSource<T> {
    void subscribe(Observer<T> observer);
}
