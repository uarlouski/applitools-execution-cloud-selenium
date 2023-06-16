# README

```bash
EYES_SERVER_URL=... API_KEY=... ./gradlew run
```

## Bad Request on applitools:startTest (fixed, obsolete documentation)

[Docs](https://applitools.com/docs/topics/execution-cloud/non-eyes.html)

Java stack trace:

```
> Task :run
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
eyes | 2023-06-15 12:49:26.857 | [info] | Logs saved in: /var/folders/3_/tcwlhbyd53q24p4wgclss95r0000gn/T/applitools-logs
Jun 15, 2023 12:49:26 PM org.openqa.selenium.remote.tracing.opentelemetry.OpenTelemetryTracer createTracer
INFO: Using OpenTelemetry for tracing
Exception in thread "main" org.openqa.selenium.WebDriverException: Body cannot be empty when content-type is set to 'application/json'
Build info: version: '4.9.1', revision: 'eb2032df7f'
System info: os.name: 'Mac OS X', os.arch: 'x86_64', os.version: '12.3.1', java.version: '17.0.2'
Driver info: org.openqa.selenium.remote.RemoteWebDriver
Command: [b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7, quit {}]
Capabilities {acceptInsecureCerts: false, applitools:isECClient: true, browserName: chrome, browserVersion: 114.0.5735.106, chrome: {chromedriverVersion: 114.0.5735.90 (386bc09e8f4f..., userDataDir: /tmp/.com.google.Chrome.npIlpD}, goog:chromeOptions: {debuggerAddress: localhost:34341}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: linux, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
Session ID: b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7
        at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
        at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
        at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:200)
        at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:133)
        at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)
        at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:193)
        at org.openqa.selenium.remote.TracedCommandExecutor.execute(TracedCommandExecutor.java:51)
        at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:543)
        at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:598)
        at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:602)
        at org.openqa.selenium.remote.RemoteWebDriver.quit(RemoteWebDriver.java:445)
        at org.example.Main.main(Main.java:32)
```

Core universal logs:

```
core-universal | 2023-06-15T09:49:24.547Z [INFO ] Core universal is going to be initialized with options {
  debug: false,
  shutdownMode: 'stdin',
  idleTimeout: 900000,
  printStdout: false,
  _: [ 'universal' ],
  'port 0': true,
  singleton: false,
  'shutdown-mode': 'stdin',
  shutdown: 'stdin',
  port: 21077,
  fork: false,
  'port-resolution-mode': 'next',
  'port-resolution': 'next',
  portResolution: 'next',
  portResolutionMode: 'next',
  'idle-timeout': 900000,
  '$0': '/private/var/folders/3_/tcwlhbyd53q24p4wgclss95r0000gn/T/core-macos'
}
core-universal | 2023-06-15T09:49:24.559Z [INFO ] Core universal is started on port 21077
socket | 2023-06-15T09:49:26.758Z [INFO ] Emit event of type "Logger.log" with payload {
    "level": "info",
    "message": "Logs saved in: /var/folders/3_/tcwlhbyd53q24p4wgclss95r0000gn/T/applitools-logs"
}
socket | 2023-06-15T09:49:26.871Z [INFO ] Received event of type {"name":"Core.makeCore"} with payload {
    "agentId": "eyes.sdk.java/5.54.0",
    "cwd": "/Users/uarlouski/Workspace/Repositories/applitools-execution-cloud-selenium",
    "spec": "webdriver"
}
core | 2023-06-15T09:49:26.872Z [INFO ] Core is initialized without custom base core
core-base | 2023-06-15T09:49:26.872Z [INFO ] Core is initialized in directory /Users/uarlouski/Workspace/Repositories/applitools-execution-cloud-selenium for agent eyes-universal/3.2.1/eyes.sdk.java/5.54.0
socket | 2023-06-15T09:49:26.874Z [INFO ] Received event of type {"name":"Core.makeManager","key":"d7cc5eb2-7987-4725-8392-22fedd859db3"} with payload {
    "type": "classic"
}
core (manager-classic-2m4) | 2023-06-15T09:49:26.874Z [INFO ] Command "makeManager" is called with settings {
  concurrency: 5,
  legacyConcurrency: undefined,
  agentId: 'eyes-universal/3.2.1/eyes.sdk.java/5.54.0',
  batch: { id: 'generated-130ab934-53ca-4738-8d35-369dd9fb2d33' }
}
core-base (manager-classic-2m4) | 2023-06-15T09:49:26.874Z [INFO ] Core is initialized in directory /Users/uarlouski/Workspace/Repositories/applitools-execution-cloud-selenium for agent eyes-universal/3.2.1/eyes.sdk.java/5.54.0
core-ufg (manager-classic-2m4) | 2023-06-15T09:49:26.874Z [INFO ] Core ufg is initialized with custom base core
core-classic (manager-classic-2m4) | 2023-06-15T09:49:26.874Z [INFO ] Core classic is initialized with custom base core
socket | 2023-06-15T09:49:26.875Z [INFO ] Emit event of type {"name":"Core.makeManager","key":"d7cc5eb2-7987-4725-8392-22fedd859db3"} with payload {
    "result": {
        "applitools-ref-id": "496ca4a5-c47b-471b-8ab3-2aaf8b78a191"
    }
}
socket | 2023-06-15T09:49:26.879Z [INFO ] Received event of type {"name":"Core.getECClient","key":"7fa726b8-ab55-464b-aab6-0cccc505de7e"} with payload {}
ec-client | 2023-06-15T09:49:26.880Z [INFO ] Proxy server has started on port 57075
socket | 2023-06-15T09:49:26.880Z [INFO ] Emit event of type {"name":"Core.getECClient","key":"7fa726b8-ab55-464b-aab6-0cccc505de7e"} with payload {
    "result": {
        "url": "http://localhost:57075"
    }
}
ec-client (proxy-request-s7s) | 2023-06-15T09:49:27.245Z [INFO ] Received request [POST] /session
ec-client (proxy-request-s7s) | 2023-06-15T09:49:27.246Z [INFO ] Request was intercepted with body: {
  capabilities: {
    firstMatch: [
      {
        'applitools:apiKey': '...',
        'applitools:eyesServerUrl': '...',
        browserName: 'chrome'
      }
    ]
  }
}
ec-client (proxy-request-s7s) | 2023-06-15T09:49:27.246Z [INFO ] Request body has modified: {
  capabilities: {
    firstMatch: [
      {
        'applitools:apiKey': '...',
        'applitools:eyesServerUrl': '...',
        browserName: 'chrome',
        'applitools:batch': {
          id: 'generated-a8679cff-3522-4b1a-8c26-0cc3f8c65671',
          name: undefined,
          sequenceName: undefined,
          notifyOnCompletion: undefined
        },
        'applitools:tunnel': undefined,
        'applitools:useSelfHealing': undefined,
        'applitools:sessionName': undefined,
        'applitools:timeout': undefined,
        'applitools:inactivityTimeout': undefined,
        'applitools:browserName': 'chrome'
      }
    ]
  }
}
ec-client (proxy-request-s7s/queue-{"eyesServerUrl":"...","apiKey":"..."}) | 2023-06-15T09:49:27.247Z [INFO ] Task was added to the queue
ec-client (proxy-request-s7s) | 2023-06-15T09:49:28.780Z [INFO ] Response was intercepted with body: {
  value: {
    capabilities: {
      acceptInsecureCerts: false,
      browserName: 'chrome',
      browserVersion: '114.0.5735.106',
      chrome: {
        chromedriverVersion: '114.0.5735.90 (386bc09e8f4f2e025eddae123f36f6263096ae49-refs/branch-heads/5735@{#1052})',
        userDataDir: '/tmp/.com.google.Chrome.npIlpD'
      },
      'goog:chromeOptions': { debuggerAddress: 'localhost:34341' },
      networkConnectionEnabled: false,
      pageLoadStrategy: 'normal',
      platformName: 'linux',
      proxy: {},
      setWindowRect: true,
      strictFileInteractability: false,
      timeouts: { implicit: 0, pageLoad: 300000, script: 30000 },
      unhandledPromptBehavior: 'dismiss and notify',
      'webauthn:extension:credBlob': true,
      'webauthn:extension:largeBlob': true,
      'webauthn:extension:minPinLength': true,
      'webauthn:extension:prf': true,
      'webauthn:virtualAuthenticators': true
    },
    sessionId: 'b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7'
  }
}
ec-client (proxy-request-s7s) | 2023-06-15T09:49:28.819Z [INFO ] Request was responded with status 200
ec-client (proxy-request-g9j) | 2023-06-15T09:49:31.382Z [INFO ] Received request [POST] /session/b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7/url
ec-client (proxy-request-g9j) | 2023-06-15T09:49:31.386Z [INFO ] Passthrough request
ec-client (proxy-request-g9j) | 2023-06-15T09:49:32.195Z [INFO ] Request was responded with status 200
ec-client (proxy-request-f6a) | 2023-06-15T09:49:32.281Z [INFO ] Received request [POST] /session/b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7/execute/sync
ec-client (proxy-request-f6a) | 2023-06-15T09:49:32.282Z [INFO ] Custom script execution was intercepted with body: { script: 'applitools:startTest', args: [ 'test-name', 'app-name' ] }
driver (proxy-request-f6a) | 2023-06-15T09:49:33.317Z [INFO ] Extracted driver info { sessionId: 'b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7' }
driver (proxy-request-f6a) | 2023-06-15T09:49:33.317Z [INFO ] Extracted driver capabilities {
  acceptInsecureCerts: false,
  browserName: 'chrome',
  browserVersion: '114.0.5735.106',
  chrome: {
    chromedriverVersion: '114.0.5735.90 (386bc09e8f4f2e025eddae123f36f6263096ae49-refs/branch-heads/5735@{#1052})',
    userDataDir: '/tmp/.com.google.Chrome.npIlpD'
  },
  'goog:chromeOptions': { debuggerAddress: 'localhost:34341' },
  networkConnectionEnabled: false,
  pageLoadStrategy: 'normal',
  platformName: 'linux',
  proxy: {},
  setWindowRect: true,
  strictFileInteractability: false,
  timeouts: { implicit: 0, pageLoad: 300000, script: 30000 },
  unhandledPromptBehavior: 'dismiss and notify',
  'webauthn:extension:credBlob': true,
  'webauthn:extension:largeBlob': true,
  'webauthn:extension:minPinLength': true,
  'webauthn:extension:prf': true,
  'webauthn:virtualAuthenticators': true,
  'applitools:isECClient': true
}
driver (proxy-request-f6a) | 2023-06-15T09:49:33.317Z [INFO ] Extracted capabilities environment {
  browserName: 'chrome',
  browserVersion: '114.0.5735.106',
  platformName: 'linux',
  platformVersion: undefined,
  isW3C: true,
  isMobile: false,
  isChrome: true,
  isECClient: true
}
driver (proxy-request-f6a) | 2023-06-15T09:49:33.317Z [INFO ] Executing poll script
driver (proxy-request-f6a) | 2023-06-15T09:49:34.698Z [INFO ] Polling...
driver (proxy-request-f6a) | 2023-06-15T09:49:35.343Z [INFO ] Extracted user agent {
  legacy: 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36',
  brands: [
    { brand: 'Not.A/Brand', version: '8' },
    { brand: 'Chromium', version: '114' },
    { brand: 'Google Chrome', version: '114' }
  ],
  mobile: false,
  model: '',
  platform: 'Linux',
  platformVersion: '5.10.162'
}
driver (proxy-request-f6a) | 2023-06-15T09:49:35.344Z [INFO ] Extracted user agent environment {
  browserName: 'Chrome',
  browserVersion: '114.0',
  platformName: 'Linux',
  platformVersion: '5.10.162',
  deviceName: undefined,
  isMobile: false,
  isChromium: true,
  isReliable: true
}
driver (proxy-request-f6a) | 2023-06-15T09:49:35.345Z [INFO ] Extracted environment {
  browserName: 'Chrome',
  browserVersion: '114.0',
  platformName: 'Linux',
  platformVersion: '5.10.162',
  isW3C: true,
  isMobile: false,
  isChrome: true,
  isECClient: true,
  isWeb: true,
  deviceName: undefined,
  isChromium: true,
  isReliable: true,
  isIE: false,
  isEdge: false,
  isEdgeLegacy: false,
  isWindows: false,
  isMac: false,
  isAndroid: false,
  isIOS: false,
  isEC: true
}
driver (proxy-request-f6a) | 2023-06-15T09:49:35.345Z [INFO ] Switching to a child context with depth: 0
driver (proxy-request-f6a) | 2023-06-15T09:49:35.871Z [INFO ] Extracted title: Example Domain
driver (proxy-request-f6a) | 2023-06-15T09:49:35.871Z [INFO ] Extracting viewport size from web driver using js snippet
driver (proxy-request-f6a) | 2023-06-15T09:49:36.275Z [INFO ] Extracted viewport size { height: 961, width: 1919 }
ec-client (proxy-request-f6a) | 2023-06-15T09:49:40.693Z [ERROR] Error during processing request Error: Request "openFunctionalSession" that was sent to the address "[POST].../api/sessions/running?apiKey=..." failed due to unexpected status Bad Request(400)
    at Object.afterResponse (/snapshot/core/node_modules/@applitools/core-base/dist/server/req-eyes.js:103:23)
    at /snapshot/core/node_modules/@applitools/req/dist/index.cjs:9357:97
    at processTicksAndRejections (internal/process/task_queues.js:95:5)
    at async req2 (/snapshot/core/node_modules/@applitools/req/dist/index.cjs:9268:18)
    at async req (/snapshot/core/node_modules/@applitools/req/dist/index.cjs:9222:12)
    at async Object.openFunctionalSession (/snapshot/core/node_modules/@applitools/core-base/dist/server/requests.js:156:26)
    at async /snapshot/core/node_modules/@applitools/core-base/dist/open-functional-session.js:46:59
ec-client (proxy-request-f6a) | 2023-06-15T09:49:40.696Z [INFO ] Request was responded with status 500
ec-client (proxy-request-2cr) | 2023-06-15T09:49:40.739Z [INFO ] Received request [DELETE] /session/b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7
ec-client (proxy-request-2cr) | 2023-06-15T09:49:40.739Z [INFO ] Request was intercepted with sessionId: b7d8f2d0-f7b4-4f5d-abec-45cf5abef1e7
ec-client (proxy-request-2cr) | 2023-06-15T09:49:41.402Z [INFO ] Request was responded with status 400
```
