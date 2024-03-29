//package com.datastructureexercises.redis;
//
//public class RedisSetting extends AbstractSetting {
//    private RedisClient client = RedisClient.create("redis://localhost:6379");
//
//    @Override
//    protected String lookupCache(String key) {
//        try (StatefulRedisConnection<String, String> connection = client.connect()) {
//            RedisCommands<String, String> commands = connection.sync();
//            return commands.get(key);
//        }
//    }
//
//    @Override
//    protected void putIntoCache(String key, String value) {
//        try (StatefulRedisConnection<String, String> connection = client.connect()) {
//            RedisCommands<String, String> commands = connection.sync();
//            commands.set(key, value);
//        }
//    }
//}
