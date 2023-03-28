import { IManpad } from "../imanpad";
import { Page } from "./page";
import { RootLinks } from "./root-links";

export interface HttpResponseLab_dp {
    _embedded: {
        manpadses: IManpad[];
      };
      _links: RootLinks;
      page: Page;
}
