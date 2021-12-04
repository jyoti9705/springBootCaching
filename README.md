# springBootCaching

1. Caching keeps frequently accessed data closer to your application so that you can avoid hitting database , speed up
   your access and save monetary cost
2. Why cache? Where to cache?
    1. Better performance
        1. Fewer network and database calls
        2. Better Scaling
            1. Database can serve more customers
        3. Distributed Caching
            1. Closer to end user
        4. Exception Handling
        5. Do it at service layers where DAO's are integrated
            1. Save calls to DAO
3. Pros and Cons
    1. Pros
        1. Increased performance
        2. Less Disk I/O
        3. Scalable Database
    2. Cons
        1. Requires RAM to hold onto memory
4. Spring provided abstraction to EhCacheManager , so we do not need to directly extend EhCache we can make use of
   Spring to use it
5. Ideally if we do not specify the third party provider for caching like Ehcache it will take the default one, but it
   is recommended to use Ehcache and other third parties proving implementation for caching for production
6. Built on to SpringBoot
    1. @EnableCaching on application class
    2. @Cacheable("name") on the method you want to do the cache
        1. Uses method parameters as key and return type as value
7. It can be applied in
    1. Client and Server communication
    2. Application layer and database layer
    3. In general between any 2 layer
8. When to use caching?
    1. There is repetitive data return for same input
    2. To save monetary cost
    3. To improve latency among layers
9. We should limit our cache in application to have faster access to the data
10. Steps to implement caching
    1. First we will have to enable caching for our application
    2. Store data in Caching
    3. Keep updating data in caching
    4. Evict Caching after certain amount of time
11. Annotations in SpringBootCaching
    1. @EnableCaching
        1. Enables the caches in the application
    2. @Cacheable
        1. Used with methods that are cacheable
        2. Method from which data returned will be stored in the cache
        3. We can provide two attributes
            1. Cache are stored in key value pair
            2. We need to specify the cacheName and the key
            3. If we do not provide cache it will take default value
            4. We can also provide the condition using which data should be stored in database
            5. We can also include synchronized config by defining sync as true
        4. Cacheable is used to add the data
    3. @CachePut
        1. CachePut is used to update the data
    4. @CacheEvict
        1. CacheEvict is used to erase data from the cache
        2. We can also specify if we want to evict all the caches
    5. @Caching
        1. To specify multiply annotations of the same type we can make use of caching on the same method
    6. @CacheConfig
        1. If all the methods are cacheable in a class we can make use of class level annotation @CacheConfig
        2. It will get applied to all the methods of class
12. All TTL policies are need to be specified in cacheProvider
13. The Cache abstraction is an abstraction , not a cache implementation
14. Dependency for cache
    1. SpringBoot starter cache
    2. SpringBoot is abstraction to all the 3rd party application providing the cache
    3. It gives us an interface for cache implementation
15. EHCache
    1. Java most widely used cache
    2. Open Source
    3. Commercial support by Terracotta
    4. robust , proven , full-featured and integrates with other popular libraries and frameworks
    5. It can be used with hibernate as
        1. General Purpose
        2. 2nd Level Cache
    6. Integrates with -spring , google app engine and others
    7. Cache hit
        1. Value is found in the cache
    8. Cache Miss
        1. Value not found in the cache
    9. System of record
        1. source of truth , mostly database
    10. Why Caching?
        1. Locality of reference
        2. Speed
        3. CostSaving
    11. Factors affecting the efficiency of the cache
        1. Liveliness
            1. Freshness of the data
        2. Proportion of Data Cached
        3. Shape of Usage Distribution
        4. Read/Write ratio
    12. Topology
        1. Standalone
            1. Data is present in the application
        2. Distributed
            1. Data is present over a location
        3. Replicated
    13. Storage Tiers
        1. Memory store - subject to GC
        2. offHeapStore - available upto RAM
        3. Disk Store
        