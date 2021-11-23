package io.github.qihuan92.rxjava;

/**
 * BasicFuseableObserver
 *
 * @author qi
 * @since 2021/11/23
 */
public abstract class BasicFuseableObserver<T, R> implements Observer<T> {

    protected final Observer<R> actual;

    public BasicFuseableObserver(Observer<R> actual) {
        this.actual = actual;
    }

    @Override
    public void onSubscribe() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
