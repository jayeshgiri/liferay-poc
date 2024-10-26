import React from "react";
import { createRoot } from "react-dom/client";
import {App} from "./app/App";
import "./index.css";

class ClientAdminWebComponent extends HTMLElement {
  connectedCallback() {
    this.root = createRoot(this);
    this.root.render(<App />, this);
  }
  disconnectedCallback() {
    this.root.unmount();
    delete this.root;
  }
}


const CLIENT_ADMIN_ELEMENT_ID = "client-admin-app";

if (!customElements.get(CLIENT_ADMIN_ELEMENT_ID)) {
  customElements.define(CLIENT_ADMIN_ELEMENT_ID, ClientAdminWebComponent);
}


