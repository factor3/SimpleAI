import './component.css'
import React from 'react';
import { marked } from 'marked';

interface TextareaProps {
    markdown: string;
    theQuestion: string;
}

/*
const processHTML = (html: string): string => {
    // Use a regular expression to find all <p> tags and insert class=ans_paragraph after each <p> tag
    const rsp = html.replace(/<p\b[^>]*>(.*?)<\/p>/gi, '<p$1 class="ans_paragraph">$2</p>');

    return(rsp);
};
 */

const TextareaComponent: React.FC<TextareaProps> = ({ markdown,theQuestion }) => {
    const parsedMarkdown = marked(markdown);
//    const html = processHTML(parsedMarkdown.toString());
    const html =parsedMarkdown.toString();

    return (
        <div>
            <textarea
                className={ (markdown=='') ? "noquestion": "question"}
                value={theQuestion}
            />
            <div className="answer">
                <div>
                    <div dangerouslySetInnerHTML={{__html: html}}/>
                </div>
            </div>
        </div>
    );
};

export default TextareaComponent;
