package test;

import java.util.function.Consumer;

@FunctionalInterface
public interface PresentOrElseHandler<T extends Object> {

    void presentOrElseHandle(Consumer<? super T> action, Runnable emptyAction);
}
