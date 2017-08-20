export interface ReviewModel {
  id: string;
  writer: string;
  password: string;
  rating: string;
  content: string;
}
//리뷰는 보류
// export interface CommentModel {
//   id: string;
//   writer: string;
//   password: string;
//   rating: string;
//   content: string;
// }


export interface DiningroomModel {
  id?: string;
  name: string;
  location: string;
  rank?: number;
  description: string;
  reviews?: ReviewModel[];
}
