import _ from 'lodash';
/**
 * Created by coolman on 2017-10-9.
 */

function component() {
    var element = document.createElement('div');

    // Lodash, now imported by this script
    element.innerHTML = _.join(['Hello', 'webpack subfolder page'], ' ');

    return element;
}

document.body.appendChild(component());