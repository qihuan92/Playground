package io.github.qihuan92.rxjava;

/**
 * Observable
 *
 * @author qi
 * @since 2021/11/23
 */
public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public void subscribeObserver(Observer<T> observer) {
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        return new ObservableCreate<>(source);
    }

    public final <U> Observable<U> map(Function<T, U> mapper) {
        return new ObservableMap<>(this, mapper);
    }
}
