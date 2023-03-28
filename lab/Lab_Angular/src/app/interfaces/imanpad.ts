import { ManpadsLinks } from "./rest-repository-resource/manpads-links";

export interface IManpad {
    id:number;
    name: string;
    weight: number;
    photo: string;
    _links?: ManpadsLinks;
}
