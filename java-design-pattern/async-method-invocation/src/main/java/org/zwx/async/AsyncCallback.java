package org.zwx.async;

import java.util.Optional;

public interface AsyncCallback<T> {

    void onComplete(T value, Optional<Exception> e);
}
