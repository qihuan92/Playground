package io.github.qihuan92.rxjava;

/**
 * ObservableCreate
 *
 * @author qi
 * @since 2021/11/23
 */
public class ObservableCreate<T> extends Observable<T> {

    private final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        CreateEmitter<T> createEmitter = new CreateEmitter<>(observer);
        source.onSubscribe(createEmitter);
    }

    static final class CreateEmitter<T> implements Emitter<T> {

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
}
