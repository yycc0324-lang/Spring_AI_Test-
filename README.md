# Spring AI Test

用 Spring AI 把几个典型玩法串起来的小demo，上手体验框架用。

- 后端：Spring Boot 3.2 + Spring AI 1.0.2（Ollama `deepseek-r1:8b`）
- 模型跑在本地 Ollama
- MySQL + MyBatis-Plus 存课程/校区/预约单数据
- 对外提供 3 个功能：基础对话、角色扮演小游戏、智能客服

## 功能

### 基础对话

`POST /ai/chat`，SSE 流式返回。默认系统提示可以自己修改，带对话记忆（`MessageWindowChatMemory`），同一个 `chatId` 上下文连着，写法和Langchain略不同，这里比Langchain逻辑复杂。

### 角色扮演小游戏（Prompt 应用）

`GET /ai/game`。这个改改 Prompt，简单了解一下实际应用场景里的 Prompt。基础框架，不拓展多模型切换以及 Prompt + 工作流切换的内容。

### 客服（Function Calling）

`POST /ai/service`。模拟教育机构客服。演示 Spring AI 的工具调用，和 LangChain 那边的写法几乎一模一样，包括直接调数据库：用 `@Tool` 注解暴露了查课程、查校区、生成预约单几个方法，模型自己决定什么时候调、传什么参，数据落在 MySQL。安全提示词里做了防注入，但模型效果一般，Tool写的不严谨。

## 技术栈

- Spring Boot 3.2
- Spring AI 1.0.0（spring-ai-starter-model-ollama）
- Ollama（deepseek-r1:8b）
- MyBatis-Plus + MySQL
- Lombok
