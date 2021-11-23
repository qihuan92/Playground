package io.github.qihuan92.rxjava;

/**
 * ObservableOnSubscribe
 *
 * @author qi
 * @since 2021/11/23
 */
public interface ObservableOnSubscribe<T> {
    void onSubscribe(Emitter<T> emitter);
}
