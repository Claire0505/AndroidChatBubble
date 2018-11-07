# AndroidChatBubble
Android聊天應用程序
<br/>
文章參考來源：<br/>
https://www.androidtutorialpoint.com/basics/android-chat-bubble-layout-9-patch-image-using-listview/?subscribe=success#blog_subscription-4

<h2>Android Chat Bubble</h2>
這是一個聊天佈局，其中兩個用戶互相發送消息，並在每條消息上創建動態ListView。
每個氣泡的大小根據消息的長度自動增加和減少。這是通過9補丁圖片完成的。<br/>

什麼是9補丁圖像:<br/>
https://developer.android.com/studio/write/draw9patch <br/>
生成9個補丁圖像的最簡單方法是使用Android Asset Studio Simple Nine-patch Generator<br/>
https://romannurik.github.io/AndroidAssetStudio/nine-patches.html#&sourceDensity=320&name=example  <br/>

在設計用戶界面時，可能希望更改背景以使應用程序具有創新外觀。<br/>
在這種情況下，應正確縮放背景，否則將產生模糊的圖像。<br/>
隨著視圖大小的變化，Android使用Nine Patch文件為縮放背景提供支持。<br/>

<h3>使用第三方類別庫 ButterKnife加快View的findViewById開發<h3>

1.build.gradle (Module:app) 加入：<br/>
apply plugin: 'com.jakewharton.butterknife' <br/>
implementation 'com.jakewharton:butterknife:9.0.0-rc1' <br/>
annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0-rc1' <br/>

2.build.gradle(Project) 加入： <br/>
classpath 'com.jakewharton:butterknife-gradle-plugin:9.0.0-rc1' <br/>
