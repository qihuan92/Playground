package io.github.qihuan92.rxjava;

/**
 * ObservableMap
 *
 * @author qi
 * @since 2021/11/23
 */
public class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    private final Function<T, U> mapper;

    public ObservableMap(Observable<T> source, Function<T, U> mapper) {
        super(source);
        this.mapper = mapper;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        source.subscribe(new MapObserver<>(observer, mapper));
    }

    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {

        private final Function<T, U> mapper;

        public MapObserver(Observer<U> actual, Function<T, U> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            U u = mapper.apply(t);
            actual.onNext(u);
        }
    }
}
