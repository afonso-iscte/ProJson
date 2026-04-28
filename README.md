# **ProJson** - JSON Generation with References

## O **ProJson** é uma biblioteca que tem como objetivo transformar objetos para o formato Json.

---

## 📍 Principais Funcionalidades:

* **Conversão:** Gera objetos e arrays JSON;
* **Referências:** Evita repetir o mesmo objeto através da anotação `@Reference` que faz referência ao objeto através do seu `$id`;
* **Customização através de Anotações:**
  * `@JsonIgnore`: Ignora uma propriedade na serialização;
  * `@JsonProperty("name")`: Altera uma chave na serialização;
  * `@JsonString(Class::class)`: Customiza a classe Date através de um plugin;
* **Pretty Print:** Formatação vertical para facilitar a leitura dos resultados.

---

## 📊 Exemplo de Output:

```json
{
"$id": "b80bc2d9-5ba9-4561-83b2-7388c289c7ba",
"$type": "Task",
"description": "T3",
"deadline": null,
"dependencies": [{
"$ref": "b214b920-923e-42bb-a162-3bba8c679e82"
}, {
"$ref": "b07de59a-52b5-420d-8e8a-534299ffb6cb"
}]
```
---

## 📥 Instalação

* **Importar o JAR:** Copiar o ficheiro `ProJson.jar` para uma pasta `lib` no seu projeto.
* **Adicionar à biblioteca:** Botão direito no ficheiro > **Add as library**.
* **Projeto Gradle (Opcional):** No ficheiro `build.gradle.kts`adiciona a seguinte linha para garantir que a biblioteca é encontrada:

```kotlin
dependencies {
    implementation(files("lib/Projson.jar"))
}
```

* **Teste de funcionamento:** Correr o seguinte teste para garantir que está funcional:

```kotlin
fun main() {

    val myTask = Task("FinishProject", null, emptyList())

    val engine = ProJson()

    val json = engine.toJson(myTask)

    println(json.toJsonString())
}
```
