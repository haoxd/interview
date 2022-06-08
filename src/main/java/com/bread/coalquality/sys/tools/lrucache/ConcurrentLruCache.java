package com.bread.coalquality.sys.tools.lrucache;


/**
 *  LruCache实现，V3版本，线程安全+高并发
 *
 * Created on Jul, 2020 by @author haoxd
 */
public class ConcurrentLruCache<K, V> {

    private ThreadSafetyLruCache<K, V>[] cacheSegments;

    public ConcurrentLruCache(final int maxCapacity) {
        int cores = Runtime.getRuntime().availableProcessors();
        int concurrency = cores < 2 ? 2 : cores;
        cacheSegments = new ThreadSafetyLruCache[concurrency];
        int segmentCapacity = maxCapacity / concurrency;
        if (maxCapacity % concurrency == 1) segmentCapacity++;
        for (int index = 0; index < cacheSegments.length; index++) {
            cacheSegments[index] = new ThreadSafetyLruCache<>(segmentCapacity);
        }
    }

    public ConcurrentLruCache(final int concurrency, final int maxCapacity) {
        cacheSegments = new ThreadSafetyLruCache[concurrency];
        int segmentCapacity = maxCapacity / concurrency;
        if (maxCapacity % concurrency == 1) segmentCapacity++;
        for (int index = 0; index < cacheSegments.length; index++) {
            cacheSegments[index] = new ThreadSafetyLruCache<>(segmentCapacity);
        }
    }

    private int segmentIndex(K key) {
        int hashCode = Math.abs(key.hashCode() * 31);
        return hashCode % cacheSegments.length;
    }

    private ThreadSafetyLruCache<K, V> cache(K key) {
        return cacheSegments[segmentIndex(key)];
    }

    public void put(K key, V value) {
        cache(key).put(key, value);
    }

    public V get(K key) {
        return cache(key).get(key);
    }

    public int size() {
        int size = 0;
        for (ThreadSafetyLruCache<K, V> cache : cacheSegments) {
            size += cache.size();
        }
        return size;
    }
}