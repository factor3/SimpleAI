import './App.css'
import TextareaComponent from "./TextareaComponent.tsx";
import {useState} from "react";
import axios from "axios";

function App() {
    const [resPonse, setResponse] = useState<string>('');
    const [query, setQuery] = useState<string>('');
    const [theQuery,setTheQuery] = useState<string>('');

    const handleChat = async (endpoint: string) => {
        const url = `http://localhost:8080${endpoint}`;
        try {
            const response = await axios.get(url, {
                params: { theQuery: query },
            });

            setResponse(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    const doChat = () => {
        setTheQuery(query);
        setQuery('');
        handleChat('/chat');
     };

    return (
        <div>
            <h1>Simple Chat Application</h1>
            <p>This application performs a simple AI chat function. It has no memory (yet). It simply receives a prompt and sends it to an LLM.</p>
            <div>
                <textarea
                    className="input_chat"
                    value={query}
                    onChange={(e) => setQuery(e.target.value)}
                    placeholder="Enter your query"
                />
                <button onClick={() => doChat()}>Ask Question</button>
                <TextareaComponent markdown={resPonse} theQuestion={theQuery} />
            </div>
        </div>
)
}

export default App
