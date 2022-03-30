import {CommonActions, StackActions} from '@react-navigation/native';
import {RouterName} from './router-name';

let navigator: any;
function setTopLevelNavigator(navigatorRef: any) {
  navigator = navigatorRef;
}

function navigate(routeName: any, params = {}) {
  RouterName.routerName = routeName;
  navigator.dispatch(
    CommonActions.navigate({
      name: routeName,
      params: params,
    }),
  );
}

function reset(routeName: any, params = {}) {
  RouterName.routerName = routeName;
  navigator.dispatch(
    CommonActions.reset({
      index: 0,
      routes: [
        {
          name: routeName,
          params: params,
        },
      ],
    }),
  );
}
function replace(routeName: any, params = {}) {
  RouterName.routerName = routeName;
  navigator.dispatch(StackActions.replace(routeName, params));
}
function goBack() {
  navigator.dispatch(CommonActions.goBack());
}

export default {
  navigate,
  replace,
  reset,
  goBack,
  setTopLevelNavigator,
};
