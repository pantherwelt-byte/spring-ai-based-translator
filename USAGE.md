# German-English Translator — Usage Guide

A Spring Boot app that translates German text to English using a local [Ollama](https://ollama.com) instance via Spring AI.

## Prerequisites

| Requirement | Details |
|---|---|
| Java 25 | Required to build and run |
| Ollama running | Accessible at `http://192.168.178.40:11434` |
| Model pulled | `llama3.2` loaded in Ollama |

To pull the model on your Ollama host:
```bash
ollama pull llama3.2
```

## Running the App

```bash
./gradlew bootRun
```

The server starts on `http://localhost:8080`.

## API

### `POST /translate`

Translates German text to English.

**Request body:**
```json
{
  "text": "Your German text here"
}
```

**Response body:**
```json
{
  "original": "Your German text here",
  "translation": "The English translation"
}
```

## Testing

### curl

```bash
curl -X POST http://localhost:8080/translate \
  -H "Content-Type: application/json" \
  -d '{"text": "Guten Morgen, wie geht es Ihnen?"}'
```

Expected response:
```json
{
  "original": "Guten Morgen, wie geht es Ihnen?",
  "translation": "Good morning, how are you?"
}
```

### More examples

```bash
# Simple greeting
curl -X POST http://localhost:8080/translate \
  -H "Content-Type: application/json" \
  -d '{"text": "Hallo, mein Name ist Klaus."}'

# Longer sentence
curl -X POST http://localhost:8080/translate \
  -H "Content-Type: application/json" \
  -d '{"text": "Ich lerne gerade Spring Boot und künstliche Intelligenz."}'
```

### HTTPie (if installed)

```bash
http POST localhost:8080/translate text="Guten Morgen"
```

## Configuration

Edit [src/main/resources/application.properties](src/main/resources/application.properties) to change the Ollama host or model:

```properties
spring.ai.ollama.base-url=http://<your-ollama-host>:11434
spring.ai.ollama.chat.options.model=llama3.2
```
