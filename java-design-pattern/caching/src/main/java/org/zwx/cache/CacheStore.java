package org.zwx.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CacheStore {
    private static Logger LOG = LoggerFactory.getLogger(CacheStore.class);

    static LruCache cache;

    private Map<String, UserAccount> localMap;


    private CacheStore() {

    }

    public static void initCapacity(int capacity) {
        if (cache == null) {
            cache = new LruCache(capacity);
            return;
        }
        cache.setCapacity(capacity);
    }


    public static UserAccount readThrough(String userId) {
        if (cache.contain(userId)) {
            return cache.getUserAccount(userId);
        }
        LOG.info("cache not have {}", userId);
        UserAccount userAccount = DbManager.get(userId);
        cache.set(userId, userAccount);
        return userAccount;
    }

    public static void writeThrough(UserAccount userAccount) {
        if (cache.contain(userAccount.getUserId())) {
            DbManager.updateDb(userAccount);
            return;
        }
        DbManager.writeToDb(userAccount);
        cache.set(userAccount.getUserId(), userAccount);
    }

    public static void writeAround(UserAccount userAccount) {
        if (cache.contain(userAccount.getUserId())) {
            DbManager.updateDb(userAccount);
            cache.invalid(userAccount.getUserId());
        } else {
            DbManager.writeToDb(userAccount);
        }
    }

    public static UserAccount readThroughWithWriteBackToDB(String userId) {
        if (cache.contain(userId)) {
            return cache.getUserAccount(userId);
        }
        LOG.info("execute write back policy");
        UserAccount userAccount = DbManager.get(userId);
        if (cache.isFull()) {
            UserAccount lastUserAccount = cache.lruData();
            DbManager.upsert(lastUserAccount);
        }
        cache.set(userId, userAccount);
        return userAccount;
    }

    public static void writeBehind(UserAccount userAccount) {
        if (cache.isFull() && cache.contain(userAccount.getUserId())) {
            UserAccount last = cache.lruData();
            DbManager.upsert(userAccount);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    public static void clear() {
        cache.clear();
    }

    public static void flush() {
        List<UserAccount> lst = cache.getCacheDataInListForm();
        lst.forEach(userAccount -> DbManager.upsert(userAccount));
    }

    public void set(UserAccount userAccount) {
        cache.set(userAccount.getUserId(), userAccount);
    }

    public void get(String userId) {
        cache.getUserAccount(userId);
    }

    public void invalidate(String userId) {
        cache.invalid(userId);
    }


}
