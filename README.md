# 🚀 Coherence AI Chat Integration  
A **Spring Boot**-based REST API and web client integration with **Coherence AI** for seamless natural language interactions, similar to OpenAI's chatbot. This project demonstrates how to use Coherence AI's chat model to process user queries and deliver intelligent, AI-driven responses.

## Website Live
[Click Here](https://coherence-ai-production.up.railway.app/chat.html)

---

## 🌟 **Features**
- **Interactive Chatbot**: Users can send queries via REST API or a responsive web interface, and receive AI-generated responses in real-time.  
- **Lightweight REST API**: Built using Spring Boot, offering a clean and scalable structure for AI integration.  
- **Responsive Web UI**: A modern, Bootstrap-styled front-end for users to interact with the AI chatbot.  
- **Error Handling**: Robust exception handling ensures smooth user experience and detailed debugging.  
- **Customizable Parameters**: Easily configure AI parameters like temperature and model using application properties.  

---

## 🛠️ **Technologies Used**
### **Backend**:
- **Java 17**: For modern, efficient, and robust development.
- **Spring Boot**: Simplifies backend development with its powerful features like dependency injection, REST API creation, and configuration.
- **Spring Validation**: For ensuring API request data integrity.
- **RestTemplate**: To send HTTP requests to Coherence AI's API.  
- **Coherence AI**: The NLP service providing chat-like responses similar to OpenAI's GPT models.

### **Frontend**:
- **HTML5 & CSS3**: For structure and styling.
- **Bootstrap 5**: Ensures a responsive and visually appealing design.
- **JavaScript**: Adds interactivity for sending queries and displaying responses.

### **DevOps**:
- **Maven**: Dependency management and build automation.
- **Postman**: For testing and debugging API endpoints.
- **Git/GitHub**: Version control and code hosting.

---

## 🖥️ **Getting Started**
### **Prerequisites**
- JDK 17 or higher
- Maven 3.8+
- A valid **Coherence API Key** from [Cohere](https://cohere.com)
- Postman (optional, for testing)

---

## API Reference
### Send Query to AI
#### URL

```http
  POST  /api/chat
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |


## 🎨 **Web Interface**
#### The project includes an intuitive and responsive web page (chat.html), allowing users to:

- Enter a query in a text box.
- View AI-generated responses in real-time.

