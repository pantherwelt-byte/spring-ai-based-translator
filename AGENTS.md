# AGENTS.md - German-English Translator

## Architecture Overview
This is a Spring Boot 3.4.3 microservice that provides German-to-English translation via REST API, using Spring AI 1.0.0 with Ollama for local LLM inference.

**Key Components:**
- `TranslationController`: Handles `/translate` POST endpoint
- `TranslationService`: Orchestrates translation using Spring AI ChatClient
- DTOs: `TranslationRequest` (input text) and `TranslationResponse` (original + translation) as records

**Data Flow:** HTTP request → Controller → Service → ChatClient → Ollama → Response

**Why this structure:** Leverages Spring AI for declarative LLM integration, keeping business logic in Service layer.

## Developer Workflows
- **Build:** `./gradlew build` (uses Gradle wrapper, no local Gradle needed)
- **Run:** `./gradlew bootRun` (starts on localhost:8080, requires Ollama running)
- **Test:** `./gradlew test` (JUnit 5, currently only contextLoads test)
- **Debug:** Set breakpoints in `TranslationService.translate()` for LLM interactions

**Prerequisites:** Java 25, Ollama at `http://192.168.178.40:11434` with `llama3.1` model pulled.

## Conventions & Patterns
- **DTOs as Records:** Use records for immutable request/response objects (e.g., `record TranslationRequest(String text) {}`)
- **Service Injection:** Constructor injection for dependencies (e.g., `TranslationService(ChatClient.Builder builder)`)
- **System Prompts:** Define translation instructions in ChatClient builder (e.g., "Translate German to English. Return only translated text.")
- **Configuration:** Ollama settings in `application.properties` (base-url, model)

**External Dependencies:** Spring AI Ollama starter auto-configures ChatClient; no manual bean setup needed.

**Testing:** Use curl for API testing (see USAGE.md examples); no integration tests yet.

**Key Files:** `build.gradle` (dependencies), `TranslationService.java` (LLM integration), `application.properties` (Ollama config)</content>
<parameter name="filePath">/home/ramonramos/Documents/projects/springAI/AGENTS.md
