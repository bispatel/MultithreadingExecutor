package com.thread.common;

public interface ResultListener<T> {
	void notifyResult(T result);
}
