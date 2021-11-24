package io.github.qihuan92.rxjava;

import org.junit.Test;

public class ExampleUnitTest {

    @Test
    public void testObserver() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void onSubscribe(Emitter<String> emitter) {
                emitter.onNext("Test0!!!");
                emitter.onNext("Test1!!!");
                emitter.onNext("Test2!!!");
                emitter.onComplete();
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "Map " + s;
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "Map2 " + s;
            }
        }).subscribe(new Observer<String>() {
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