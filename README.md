```
    一个线程转换工具。
```

#### 基础功能


1. 添加依赖

    请在 build.gradle 下添加依赖。

    ``` 
        implementation 'cn.wufuqi:ConvertMainThread:1.0.1'
    ```
2. 设置jdk8或更高版本

    因为本sdk使用了jdk8才能使用的 Lambda 表达式，所以要在 build.gradle 下面配置jdk8或以上版本。

    ``` 
    android {
        ....

        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
        
    }
    ```

3. 其他线程转换到主线程


    ```
        ConvertMainThread.runOnUiThread {
            // 这里面执行的是主线程
        }
    ```

4. 主线程转换到其他线程

    ```
        ConvertMainThread.runOnNoMainThread {
            // 这里面执行的是其他线程
        }

    ```