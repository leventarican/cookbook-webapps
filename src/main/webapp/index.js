import { html, render } from './lit-html/lit-html.js';

const add = (a, b) => {
  return html`
    <h1>${a} + ${b} = 42</h1>
  `;
};

const el = document.querySelector('#container');

render(add(40, 2), el);