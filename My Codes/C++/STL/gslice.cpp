#include "stlexam.h"
#pragma hdrstop
/**************************************************************************
 *
 * gslice.cpp - Generalized slice example program. 
 *              See Class Reference Section
 *
 ***************************************************************************
 *
 * (c) Copyright 1994, 1998 Rogue Wave Software, Inc.
 * ALL RIGHTS RESERVED
 *
 * The software and information contained herein are proprietary to, and
 * comprise valuable trade secrets of, Rogue Wave Software, Inc., which
 * intends to preserve as trade secrets such software and information.
 * This software is furnished pursuant to a written license agreement and
 * may be used, copied, transmitted, and stored only in accordance with
 * the terms of such license and with the inclusion of the above copyright
 * notice.  This software and information or any other copies thereof may
 * not be provided or otherwise made available to any other person.
 *
 * Notwithstanding any other lease or license that may pertain to, or
 * accompany the delivery of, this computer software and information, the
 * rights of the Government regarding its use, reproduction and disclosure
 * are as set forth in Section 52.227-19 of the FARS Computer
 * Software-Restricted Rights clause.
 * 
 * Use, duplication, or disclosure by the Government is subject to
 * restrictions as set forth in subparagraph (c)(1)(ii) of the Rights in
 * Technical Data and Computer Software clause at DFARS 252.227-7013.
 * Contractor/Manufacturer is Rogue Wave Software, Inc.,
 * P.O. Box 2328, Corvallis, Oregon 97339.
 *
 * This computer software and information is distributed with "restricted
 * rights."  Use, duplication or disclosure is subject to restrictions as
 * set forth in NASA FAR SUP 18-52.227-79 (April 1985) "Commercial
 * Computer Software-Restricted Rights (April 1985)."  If the Clause at
 * 18-52.227-74 "Rights in Data General" is specified in the contract,
 * then the "Alternate III" clause applies.
 *
 **************************************************************************/

#include "valarray.h"  // Contains a valarray stream inserter

int main(void)
{
#ifndef _RWSTD_NO_NAMESPACE
  using namespace std;
#endif

  int ibuf[27] =   {0,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,10};  
  size_t len_buf[3] = {3,3,3};
  size_t stride_buf[3] = {9,3,1};

  // create a valarray of ints
  valarray<int>  vi(ibuf,27);

  // create length and stride valarrays
  valarray<size_t> len(len_buf,3);
  valarray<size_t> stride(stride_buf,3);

  // print out the valarray
  cout << vi << endl;

  // Print out all three dimensions (the entire valarray)
  cout << valarray<int>(vi[gslice(0,len,stride)]) << endl;

  // Print a two dimensional slice out of the middle
  valarray<size_t> len2(2);
  len2[0] = 3;
  len2[1] = 3;
  valarray<size_t> stride2(2);
  stride2[0] = 3;
  stride2[1] = 1;
  cout << valarray<int>(vi[gslice(9,len2,stride2)]) << endl;

  // Print another two dimensional slice out of the middle
  // but orthoganal to one we just did
  stride2[0] = 9;
  stride2[1] = 1;
  cout << valarray<int>(vi[gslice(3,len2,stride2)]) << endl;

  // Print out the last plane in the middle,
  // (orthoganal to both of the previous ones)
  stride2[0] = 3;
  stride2[1] = 9;
  cout << valarray<int>(vi[gslice(1,len2,stride2)]) << endl;

  // Now how about a diagonal slice,
  // upper left front to lower right back
  stride2[0] = 3;
  stride2[1] = 10;
  cout << valarray<int>(vi[gslice(0,len2,stride2)]) << endl;
  
  return 0;
}


