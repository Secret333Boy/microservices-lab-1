import HttpService, { CustomRequestInit, FetchResult } from './HttpService';

export default class ApiService extends HttpService {
  private static readonly BASE_URL = `${process.env.REACT_APP_GATEWAY_URL || 'http://192.168.49.2:80'}/api`;

  public static async get<T>(
    url: string,
    init?: CustomRequestInit
  ): Promise<FetchResult<T>> {
    return super.get<T>(this.BASE_URL + url, init);
  }

  public static async post<T>(
    url: string,
    init?: CustomRequestInit
  ): Promise<FetchResult<T>> {
    return super.post<T>(this.BASE_URL + url, init);
  }

  public static async put<T>(
    url: string,
    init?: CustomRequestInit
  ): Promise<FetchResult<T>> {
    return super.put<T>(this.BASE_URL + url, init);
  }

  public static async patch<T>(
    url: string,
    init?: CustomRequestInit
  ): Promise<FetchResult<T>> {
    return super.patch<T>(this.BASE_URL + url, init);
  }

  public static async delete<T>(
    url: string,
    init?: CustomRequestInit
  ): Promise<FetchResult<T>> {
    return super.delete<T>(this.BASE_URL + url, init);
  }
}
