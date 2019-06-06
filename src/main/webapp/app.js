import { html, render } from "./lit-html/lit-html.js";

class Connector extends HTMLElement {
    constructor() {
        super();
        this.counterValue = 0;
        this.root = this.attachShadow({mode: 'open'});
        setInterval(_ => this.increaseCounter(), 1000);
    }
    
    increaseCounter() {
        ++this.counterValue;
    }
    
    get counter() {
        return this.counterValue;
    }
    
    set counter(val) {
        this.counterValue = val;
        render(this.template(), this.root)
    }
    
    template() {
        return html`
        <h1>foobar</h1>
        <div>${this.message}:${this.counterValue}</div>
        <h1>barfoo</h1>
        `;
    }
    
    get message() {
        return this.getAttribute('message');
    }
}

customElements.define('foobar-counter', Connector) // tag-name and class-name