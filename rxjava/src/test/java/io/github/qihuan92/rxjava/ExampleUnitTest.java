package io.github.qihuan92.rxjava;

import org.junit.Test;

public class ExampleUnitTest {

    @Test
    public void testObserver() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void onSubscribe(Emitter<String> emitter) {
                emitter.onNext("Test!!!");
                emitter.onComplete();
            }
        }).subscribeObserver(new Observer<String>() {
            @Override
            public void onSubscribe() {
                System.out.println("onSubscribe()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext(" + s + ")");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError(" + e.getMessage() + ")");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete()");
            }
        });
    }
}