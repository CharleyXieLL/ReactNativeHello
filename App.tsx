import MyRouter from './src/router/index';
import * as React from 'react';
import {RootSiblingParent} from 'react-native-root-siblings';
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

function App() {
  return (
    <RootSiblingParent>
      <MyRouter />
    </RootSiblingParent>
  );
}

export default App;
