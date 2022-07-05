import '@vaadin-component-factory/vcf-nav';
import '@vaadin/app-layout';
import { AppLayout } from '@vaadin/app-layout';
import '@vaadin/app-layout/vaadin-drawer-toggle';
import '@vaadin/avatar/vaadin-avatar';
import '@vaadin/context-menu';
import '@vaadin/tabs';
import '@vaadin/tabs/vaadin-tab';
import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { router } from '../index';
import { appStore } from '../stores/app-store';
import { Layout } from './view';

interface RouteInfo {
  path: string;
  title: string;
  icon: string;
}

@customElement('main-layout')
export class MainLayout extends Layout {
  render() {
    return html`
      <vaadin-app-layout primary-section="drawer">
        <header class="view-header" slot="navbar">
          <vaadin-drawer-toggle aria-label="Menu toggle" class="view-toggle" theme="contrast"></vaadin-drawer-toggle>
          <h2 class="view-title">${appStore.currentViewTitle}</h2>
        </header>
        <section class="drawer-section" slot="drawer">
          <h1 class="app-name">${appStore.applicationName}</h1>
          <vcf-nav class="app-nav" aria-label="${appStore.applicationName}">
            ${this.getMenuRoutes().map(
              (viewRoute) => html`
                <vcf-nav-item path=${router.urlForPath(viewRoute.path)}>
                  <span class="${viewRoute.icon} nav-item-icon" slot="prefix" aria-hidden="true"></span>
                  ${viewRoute.title}
                </vcf-nav-item>
              `
            )}
          </vcf-nav>
          <footer class="app-nav-footer"></footer>
        </section>
        <slot></slot>
      </vaadin-app-layout>
    `;
  }

  connectedCallback() {
    super.connectedCallback();
    this.classList.add('block', 'h-full');
    this.reaction(
      () => appStore.location,
      () => {
        AppLayout.dispatchCloseOverlayDrawerEvent();
      }
    );
  }

  private getMenuRoutes(): RouteInfo[] {
    return [
      {
        path: 'hello',
        title: 'Hello World',
        icon: 'la la-globe',
      },

      {
        path: 'about',
        title: 'About',
        icon: 'la la-file',
      },

      {
        path: 'collaborative-master-detail-java',
        title: 'Collaborative Master Detail Java',
        icon: 'la la-columns',
      },

      {
        path: 'master-detail-java',
        title: 'Master Detail Java',
        icon: 'la la-columns',
      },

      {
        path: 'master-detail-designer',
        title: 'Master Detail Designer',
        icon: 'la la-columns',
      },

      {
        path: 'master-detail-hilla',
        title: 'Master Detail Hilla',
        icon: 'la la-columns',
      },

      {
        path: 'dashboard-pro',
        title: 'Dashboard Pro',
        icon: 'la la-chart-area',
      },

      {
        path: 'list-pro',
        title: 'List Pro',
        icon: 'la la-th',
      },

      {
        path: 'map-pro',
        title: 'Map Pro',
        icon: 'la la-map',
      },

      {
        path: 'rich-text-editor-pro',
        title: 'Rich Text Editor Pro',
        icon: 'la la-edit',
      },
    ];
  }
}
