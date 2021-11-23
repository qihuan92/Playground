package io.github.qihuan92.rxjava;

/**
 * AbstractObservableWithUpstream
 *
 * @author qi
 * @since 2021/11/23
 */
public abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {
    protected final Observable<T> source;

    public AbstractObservableWithUpstream(Observable<T> source) {
        this.source = source;
    }
}
