import requestAction, {METHOD, RequestOptions} from '.';

//首页数据
export function homeHttp() {
  return requestAction('home', new RequestOptions(METHOD.POST, null));
}
