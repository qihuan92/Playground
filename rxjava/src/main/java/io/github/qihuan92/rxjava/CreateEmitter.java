package io.github.qihuan92.rxjava;

/**
 * CreateEmitter
 *
 * @author qi
 * @since 2021/11/23
 */
public class CreateEmitter<T> implements Emitter<T> {

    private final Observer<T> observer;

    public CreateEmitter(Observer<T> observer) {
        this.observer = observer;
    }

    @Override
    public void onNext(T t) {
        observer.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        observer.onError(e);
    }

    @Override
    public void onComplete() {
        observer.onComplete();
    }
}
