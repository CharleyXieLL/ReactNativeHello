export class SendCodePostBean {
  private mobile: string;

  constructor(_mobile: string) {
    this.mobile = _mobile;
  }
}

class SendVerifyCodeSuccessVo {
  effectiveSeconds: number | undefined;
  sendSuccess: boolean | undefined;
}

export class SendCodeResponse {
  sendVerifyCodeSuccessVo: SendVerifyCodeSuccessVo | undefined;
}
