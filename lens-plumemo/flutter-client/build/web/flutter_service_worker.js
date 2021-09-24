'use strict';
const MANIFEST = 'flutter-app-manifest';
const TEMP = 'flutter-temp-cache';
const CACHE_NAME = 'flutter-app-cache';
const RESOURCES = {
  "assets/assets/json/config_tag.json": "150cefa59752cd8105f2b14e9e5e002b",
"assets/assets/json/config_archive.json": "a63cee98c6bef9dc9841c2a1ad41afb2",
"assets/assets/json/config_topic.json": "98745f9bfecfe11b0951aaad0bbf58ee",
"assets/assets/json/config_all.json": "e4d3d57c0e744dd941d80cb0f3a7702a",
"assets/assets/json/config_life.json": "91f4aff00fc150bcaafabb4812a77a01",
"assets/assets/json/config_study.json": "92f4f1fe780df68aa964fe78ffbfac95",
"assets/assets/fonts/huawen_kt.ttf": "2bd4fe0813fd329966191f6fb2165d7f",
"assets/assets/fonts/Montserrat-Bold.ttf": "ade91f473255991f410f61857696434b",
"assets/assets/fonts/Montserrat-Regular.ttf": "ee6539921d713482b8ccd4d0d23961bb",
"assets/assets/fonts/mala_icons.ttf": "ae0bd790db79c7e6521a99a261e338f9",
"assets/assets/img/flutter_04.png": "aba419355e14a84123be52bad4f9356e",
"assets/assets/img/activity_start.png": "9a4f43d4ba9a6f7a103eef7e79b1e022",
"assets/assets/img/bugly.png": "a69b853aa47cbbca2c3a945dfa1cccd2",
"assets/assets/img/wechat.png": "f93e5cd8ec449e4cfc0b8371f97414fe",
"assets/assets/img/pic_text.png": "0e25c49ff018216c4b2845514c427c7e",
"assets/assets/img/view_step.png": "26c6a21b48dcd7601bd0e44048ad4057",
"assets/assets/img/handler.png": "112b31ff1270758d4309f61813800009",
"assets/assets/img/juejin.png": "e4f98e20c16cf47e62687e4d01afc8a0",
"assets/assets/img/create_mvp.png": "46d86678abc625a0f12621cd00264cf2",
"assets/assets/img/chat_something.png": "f0cb4fe76874e5a835ce8a27c676d95b",
"assets/assets/img/flutter_02.png": "407e825825d6ca4e2b6e4671d3ae9bfd",
"assets/assets/img/mourn.png": "ff04d13fb859b0c50bdf6945615e7c36",
"assets/assets/img/kotlin_1.png": "79e75e57505c9d9f6bd27d7298594f53",
"assets/assets/img/kotlin_3.png": "8bce1b30e211e137b1f29e2c13afcfdf",
"assets/assets/img/1.0x/mala_logo.svg": "d410c557352abc992041bcc37754c73a",
"assets/assets/img/mala_logo.png": "0a3a70205b7843eb3671b7a2f339f816",
"assets/assets/img/eventbus.png": "0c965a283da2cffb491269c9adf48b1d",
"assets/assets/img/sleep_early.png": "8bf9bc403d04984d83062fd17afc54ed",
"assets/assets/img/api_1.png": "acf11ff0bdcd9b78eaee9acf31dd01a8",
"assets/assets/img/data_binding.png": "7a57e06fe3d1c5e4b561f40bd1077b64",
"assets/assets/img/api_2.png": "1e29f9a37e5d4ee0ed703d777e9db36f",
"assets/assets/img/play_1.png": "ab7843982d217ab0ffa1ef29450eb505",
"assets/assets/img/mala_logo_128.png": "a624a24766e7586e6c426770426a808e",
"assets/assets/img/study_flutter.png": "3714e5aecf50aea98829c51ef365fca7",
"assets/assets/img/activity_start.jpg": "f16911813e2aea064a9bbd885212d8cb",
"assets/assets/img/github.png": "8e19edd9c39ab207200c51a5f2a95441",
"assets/assets/img/new_day.png": "9a384a085357d08e1fb736c0fefa96b9",
"assets/assets/img/touch_event.png": "bf09a69aefa57857971cbc417b010a9e",
"assets/assets/img/kotlin_4.png": "08bee753c19dc3c38a5e4164c80a9701",
"assets/assets/img/kotlin_2.png": "06bc549c3551be9b1832315ae62fd4a0",
"assets/assets/img/loading.gif": "8631702de01e07a5c200ebf294df1e2f",
"assets/assets/img/mala_logo.svg": "d410c557352abc992041bcc37754c73a",
"assets/assets/img/zongjie_2019.png": "9dc758759d0209893880d2fecd717c39",
"assets/assets/img/%25E5%258F%258B%25E9%2593%25BE1.jpg": "c2551a823197f39c064d6002ad11a871",
"assets/assets/img/head.png": "bf4de78bae7917467d833f6c7f009d37",
"assets/assets/img/lock.png": "b1c8da3b7b41c423315097f88c43279b",
"assets/assets/img/room_database.png": "12f7230c70accfbdf91701f000f52758",
"assets/assets/img/my_idea.png": "67338b884252a1fc2be773c471a3d0fa",
"assets/assets/img/wish_list.png": "2e5fcc14d0f0ce01d7c11729b5654bbd",
"assets/assets/img/guoqing_2019.png": "684191c50b526645af8e39f29f0b3627",
"assets/assets/img/kotlin_5.png": "4b91717f23bbe0207c589df77e5969d2",
"assets/assets/img/retrofit.png": "510ea2f828ec235350204a1823f0c695",
"assets/assets/img/hashmap.png": "e8fb0a971fcd6f8da76982245395bf08",
"assets/assets/img/flutter_03.png": "30c68ee694f153a8e96ca4fafae2902f",
"assets/assets/img/2.0x/mala_logo.svg": "77afa8d547e366be630561f713790797",
"assets/assets/img/flutter_01.png": "04eca5a5cf95fc6fc24a53587601a76e",
"assets/assets/img/flutter_05.png": "2501b597c2b808cca8bbb7f2001f116c",
"assets/assets/img/steam.png": "4d601f62031ddc22684d3d2925005b47",
"assets/assets/img/geometry-background.png": "61a11b085b3c4610338f216f3efef75a",
"assets/assets/img/wechat_pay.png": "a2f2b42b37b353a720aa841bb1fd21c7",
"assets/assets/img/changlu.png": "db45516660102ce479929d3cf0e6f6e7",
"assets/AssetManifest.json": "1a63d1540a981e739fd22670f7826696",
"assets/packages/open_iconic_flutter/assets/open-iconic.woff": "3cf97837524dd7445e9d1462e3c4afe2",
"assets/packages/cupertino_icons/assets/CupertinoIcons.ttf": "115e937bb829a890521f72d2e664b632",
"assets/FontManifest.json": "fb69c65dc7626878b8f8a687ca210787",
"assets/fonts/MaterialIcons-Regular.otf": "a68d2a28c526b3b070aefca4bac93d25",
"assets/NOTICES": "f9b30fb8d1bc5cc762596456599145b6",
"main.dart.js": "8697560105419c19b760ce5431f522dc",
"manifest.json": "7572ad49f703cb1a811c0d03b5d813b6",
"index.html": "c62bc15581c28b3b3943c825b06ab35a",
"/": "c62bc15581c28b3b3943c825b06ab35a",
"favicon.png": "5dcef449791fa27946b3d35ad8803796",
"icons/Icon-192.png": "ac9a721a12bbc803b44f645561ecb1e1",
"icons/Icon-512.png": "96e752610906ba2a93c65f8abe1645f1"
};

// The application shell files that are downloaded before a service worker can
// start.
const CORE = [
  "/",
"main.dart.js",
"index.html",
"assets/NOTICES",
"assets/AssetManifest.json",
"assets/FontManifest.json"];

// During install, the TEMP cache is populated with the application shell files.
self.addEventListener("install", (event) => {
  return event.waitUntil(
    caches.open(TEMP).then((cache) => {
      // Provide a 'reload' param to ensure the latest version is downloaded.
      return cache.addAll(CORE.map((value) => new Request(value, {'cache': 'reload'})));
    })
  );
});

// During activate, the cache is populated with the temp files downloaded in
// install. If this service worker is upgrading from one with a saved
// MANIFEST, then use this to retain unchanged resource files.
self.addEventListener("activate", function(event) {
  return event.waitUntil(async function() {
    try {
      var contentCache = await caches.open(CACHE_NAME);
      var tempCache = await caches.open(TEMP);
      var manifestCache = await caches.open(MANIFEST);
      var manifest = await manifestCache.match('manifest');

      // When there is no prior manifest, clear the entire cache.
      if (!manifest) {
        await caches.delete(CACHE_NAME);
        contentCache = await caches.open(CACHE_NAME);
        for (var request of await tempCache.keys()) {
          var response = await tempCache.match(request);
          await contentCache.put(request, response);
        }
        await caches.delete(TEMP);
        // Save the manifest to make future upgrades efficient.
        await manifestCache.put('manifest', new Response(JSON.stringify(RESOURCES)));
        return;
      }

      var oldManifest = await manifest.json();
      var origin = self.location.origin;
      for (var request of await contentCache.keys()) {
        var key = request.url.substring(origin.length + 1);
        if (key == "") {
          key = "/";
        }
        // If a resource from the old manifest is not in the new cache, or if
        // the MD5 sum has changed, delete it. Otherwise the resource is left
        // in the cache and can be reused by the new service worker.
        if (!RESOURCES[key] || RESOURCES[key] != oldManifest[key]) {
          await contentCache.delete(request);
        }
      }
      // Populate the cache with the app shell TEMP files, potentially overwriting
      // cache files preserved above.
      for (var request of await tempCache.keys()) {
        var response = await tempCache.match(request);
        await contentCache.put(request, response);
      }
      await caches.delete(TEMP);
      // Save the manifest to make future upgrades efficient.
      await manifestCache.put('manifest', new Response(JSON.stringify(RESOURCES)));
      return;
    } catch (err) {
      // On an unhandled exception the state of the cache cannot be guaranteed.
      console.error('Failed to upgrade service worker: ' + err);
      await caches.delete(CACHE_NAME);
      await caches.delete(TEMP);
      await caches.delete(MANIFEST);
    }
  }());
});

// The fetch handler redirects requests for RESOURCE files to the service
// worker cache.
self.addEventListener("fetch", (event) => {
  var origin = self.location.origin;
  var key = event.request.url.substring(origin.length + 1);
  // Redirect URLs to the index.html
  if (event.request.url == origin || event.request.url.startsWith(origin + '/#')) {
    key = '/';
  }
  // If the URL is not the RESOURCE list, skip the cache.
  if (!RESOURCES[key]) {
    return event.respondWith(fetch(event.request));
  }
  event.respondWith(caches.open(CACHE_NAME)
    .then((cache) =>  {
      return cache.match(event.request).then((response) => {
        // Either respond with the cached resource, or perform a fetch and
        // lazily populate the cache. Ensure the resources are not cached
        // by the browser for longer than the service worker expects.
        var modifiedRequest = new Request(event.request, {'cache': 'reload'});
        return response || fetch(modifiedRequest).then((response) => {
          cache.put(event.request, response.clone());
          return response;
        });
      })
    })
  );
});

self.addEventListener('message', (event) => {
  // SkipWaiting can be used to immediately activate a waiting service worker.
  // This will also require a page refresh triggered by the main worker.
  if (event.data === 'skipWaiting') {
    return self.skipWaiting();
  }

  if (event.message === 'downloadOffline') {
    downloadOffline();
  }
});

// Download offline will check the RESOURCES for all files not in the cache
// and populate them.
async function downloadOffline() {
  var resources = [];
  var contentCache = await caches.open(CACHE_NAME);
  var currentContent = {};
  for (var request of await contentCache.keys()) {
    var key = request.url.substring(origin.length + 1);
    if (key == "") {
      key = "/";
    }
    currentContent[key] = true;
  }
  for (var resourceKey in Object.keys(RESOURCES)) {
    if (!currentContent[resourceKey]) {
      resources.push(resourceKey);
    }
  }
  return contentCache.addAll(resources);
}
