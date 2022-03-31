export enum METHOD {
  GET = 'GET',
  POST = 'POST',
}

export class RequestOptions<T> {
  method: METHOD = METHOD.POST;
  body: T | undefined;

  constructor(method: METHOD, body: T) {
    this.method = method;
    this.body = body;
  }
}

// class BasicParams {
//   appKey: string = '123456';
//   appVersion: string = '1.0.0';
//   channel: string = 'xx';
//   appClient: string = 'rn';
//   openId: string = 'a77c52e3-06bd-4179-8481-061ac9697282';
//   from: string = 'cashloan';
//   clientId: string = 'a77c52e3-06bd-4179-8481-061ac9697282';
//   timestamp: string = new Date().getTime().toString();
//   net: string = 'wifi';
//   versionCode: number = 100;
//   token: string = '';
//   guestId: string = 'a77c52e3-06bd-4179-8481-061ac9697282';
//   appCode: string = '0000002';
//   categoryCode: string = 'xxx';
//   appSign: string = '';
// }

// function getBasicParams<T>(options: RequestOptions<T>): BasicParams {
//   let appSecret = '460bd2ae05a0756a443b72778a9e96b9';

//   let basicParams = new BasicParams();

//   let bodyStr;
//   if (options.body) {
//     bodyStr =
//       Object.keys(options.body as unknown as object).length > 0
//         ? JSON.stringify(options.body)
//         : '{}';
//   } else {
//     bodyStr = '';
//   }

//   basicParams.appSign = stringMd5(stringMd5(appSign));
//   return basicParams;
// }

const baseUrl =
  process.env.NODE_ENV === 'production' ? 'xxx' : 'http://jhbeibaoke.com:8071/';

export default function requestAction<T>(
  url: string,
  options: RequestOptions<T>,
) {
  let method: METHOD = METHOD.POST;
  if (options.method) {
    method = options.method;
  }

  return fetch(baseUrl + url, {
    method,
    headers: {
      'Content-Type': 'application/json;charset=utf-8',
    },
    body: JSON.stringify(options.body),
  })
    .then(res => res.json())
    .then(data => {
      console.log(url, '---返回结果----', data);
      if (data.code === 0) {
        return data.data;
      } else {
      }
    });
}
