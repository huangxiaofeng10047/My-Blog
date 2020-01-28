package com.site.blog.my.core.service;

public interface RedisService {
    public boolean set(final String key, final String value);

    public String get(final String key);

    public String incr(final String key);
}
