# Youtrack Kotlin Js
Demo project for import errors of sqldelight in angular

## Setup
- Run gradle task `jsBrowserDevelopmentWebpack`
- Run `npm i` in angularApp directory
- Switch to `angularApp` directory and run `npm run start` to serve angular application

## Error
Browser debug menu will show WebWorkerException below due to import not allowed outside of module.

```
{
    "message": "{\"message\":\"Uncaught SyntaxError: Cannot use import statement outside a module\",\"type\":\"error\"}isTrusted,true",
    "name": "WebWorkerException"
}
```