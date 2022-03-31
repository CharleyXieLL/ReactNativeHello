import * as React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';

import MainScreen from '../pages/main/index';
import DetailScreen from '../pages/detail/index';
import NavigationService from './NavigationService';
import SplashScreen from '../pages/splash/index';
import LoginScreen from '../pages/login/index';

export enum RouterScreen {
  SPLASH = 'Splash',
  LOGIN = 'Login',
  MAIN = 'Main',
  HOME = 'Home',
  PROFILE = 'Profile',
  MINE = 'Mine',
  DETAIL = 'Detail',
}

const Stack = createNativeStackNavigator();

function MyRouter() {
  return (
    <NavigationContainer
      ref={navigationRef => {
        NavigationService.setTopLevelNavigator(navigationRef);
      }}>
      <Stack.Navigator screenOptions={{animation: 'none'}}>
        <Stack.Screen
          name={RouterScreen.SPLASH}
          component={SplashScreen}
          options={{headerShown: false}}
        />
        <Stack.Screen
          name={RouterScreen.LOGIN}
          component={LoginScreen}
          options={{headerShown: false}}
        />
        <Stack.Screen
          name={RouterScreen.MAIN}
          component={MainScreen}
          options={{headerShown: false}}
        />
        <Stack.Screen
          name={RouterScreen.DETAIL}
          component={DetailScreen}
          options={{headerShown: false}}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default MyRouter;
